package com.bfsi.mfi.entity;

import java.io.StringWriter;
import java.util.Date;

import javax.persistence.Entity;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@Entity(name = "mfi_audit_detail")
public class AuditTrail<E extends MaintenanceEntity> {
	private static Marshaller marshaller = null;

	static {
		JAXBContext context;
		try {
			context = JAXBContext.newInstance("com.bfsi.mfi.entity");
			marshaller = context.createMarshaller();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	private MaintenanceEntity entity;
	private String tableName;
	private String keyId;
	private String objectXml = "";
	private String maker;
	private Date makerTimestamp;
	private String checker;
	private Date checkerTimestamp;
	private Integer version;

	/**
	 * To be used when retrieving back records from data store where we might
	 * want to lazily unmarshal entities
	 */
	public AuditTrail() {

	}

	/**
	 * Create an audit trail object from the given entity
	 * 
	 * @param entity
	 */
	public AuditTrail(E entity) {
		this.entity = entity;
		this.tableName = getTableNameFromMapping(entity);
		this.keyId = entity.getId();
		this.maker = entity.getMaker();
		this.makerTimestamp = entity.getMakerTimestamp();
		this.checker = entity.getChecker();
		this.checkerTimestamp = entity.getCheckerTimestamp();

		// serialize the entity to XML and hold it as string
		this.objectXml = getObjectXmlFromEntity(entity);
	}

	/**
	 * Marshals given entity to XML string
	 * 
	 * @param entity
	 * @return
	 */
	public static <T extends MaintenanceEntity> String getObjectXmlFromEntity(
			T entity) {
		StringWriter writer = new StringWriter();
		try {
			marshaller.marshal(entity, writer);
			return writer.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Based on JPA mapping in the class of given entity object, table name is
	 * retrieved
	 * 
	 * @param entity
	 * @return
	 */
	public static <T extends MaintenanceEntity> String getTableNameFromMapping(
			T entity) {
		Class<? extends MaintenanceEntity> entityClass = entity.getClass();
		Entity entityAnnotation = entityClass.getAnnotation(Entity.class);

		return (entityAnnotation != null) ? entityAnnotation.name() : "";
	}

	public MaintenanceEntity getEntity() {
		return entity;
	}

	public void setEntity(MaintenanceEntity entity) {
		this.entity = entity;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getKeyId() {
		return keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	public String getObjectXml() {
		return objectXml;
	}

	public void setObjectXml(String objectXml) {
		this.objectXml = objectXml;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public Date getMakerTimestamp() {
		return makerTimestamp;
	}

	public void setMakerTimestamp(Date makerTimestamp) {
		this.makerTimestamp = makerTimestamp;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public Date getCheckerTimestamp() {
		return checkerTimestamp;
	}

	public void setCheckerTimestamp(Date checkerTimestamp) {
		this.checkerTimestamp = checkerTimestamp;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
