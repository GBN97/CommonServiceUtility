package com.sixdee.utils.supporters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * BasicEntityIdGenerator
 *
 * 
 * id is composed of: time - 41 bits (millisecond precision w/ a custom epoch
 * gives us 69 years) configured machine id - 10 bits - gives us up to 1024
 * machines sequence number - 12 bits - rolls over every 4096 per machine (with
 * protection to avoid rollover in the same ms)
 *
 */

@Component
public class Sequencer {

	private static final Logger LOGGER = LoggerFactory.getLogger(Sequencer.class);

	private final long twepoch = 1288834974657L;
	// private final long datacenterId;

	private volatile long lastTimestamp = -1L;
	private volatile long sequence = 0L;

	int sequenceLimit;

	public Sequencer() {
		sequenceLimit = 10;

	}

	public synchronized String getSequenceId() {
		long timestamp = System.currentTimeMillis();
		if (timestamp < lastTimestamp) {
			LOGGER.warn("Clock moved backwards.  Refusing to generate id for " + (lastTimestamp - timestamp)
					+ " milliseconds.");
		}
		if (lastTimestamp == timestamp) {
			sequence = (sequence + 1);
			if (sequence == 0) {
				timestamp = tilNextMillis(lastTimestamp);
			}
		} else {
			sequence = sequenceLimit;
		}
		lastTimestamp = timestamp;

		String val = String.format("%d%d", sequence, (timestamp - twepoch));
		return val;
	}

	protected long tilNextMillis(long lastTimestamp) {
		long timestamp = System.currentTimeMillis();
		while (timestamp <= lastTimestamp) {
			timestamp = System.currentTimeMillis();
		}
		return timestamp;
	}

}
