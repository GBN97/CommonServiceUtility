package com.sixdee.utils;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.fasterxml.uuid.Generators;

/** 
* @author balu.s
**/

public class UUIDGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		return String.valueOf(Generators.timeBasedGenerator().generate().timestamp());
	}

	/**
	 * Generates UUID
	 *
	 * @return UUID
	 */
	public static String getUUID(){
		return String.valueOf(Generators.timeBasedGenerator().generate().timestamp());
	}

}

