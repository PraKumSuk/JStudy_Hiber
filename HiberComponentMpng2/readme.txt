Getting an exception like below during initialisation however records are inserted in DB well

INFO: HHH000400: Using dialect: org.hibernate.dialect.MySQL5Dialect
May 25, 2016 4:06:23 PM org.hibernate.engine.jdbc.env.internal.LobCreatorBuilderImpl useContextualLobCreation
INFO: HHH000423: Disabling contextual LOB creation as JDBC driver reported JDBC version [3] less than 4
org.hibernate.MappingException: Unknown entity: com.spk.Address
	at org.hibernate.internal.SessionFactoryImpl.getEntityPersister(SessionFactoryImpl.java:781)
	at org.hibernate.internal.SessionImpl.getEntityPersister(SessionImpl.java:1520)
	at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:100)
	at org.hibernate.event.internal.DefaultSaveOrUpdateEventListener.saveWithGeneratedOrRequestedId(DefaultSaveOrUpdateEventListener.java:192)
	at org.hibernate.event.internal.DefaultSaveEventListener.saveWithGeneratedOrRequestedId(DefaultSaveEventListener.java:38)
	at org.hibernate.event.internal.DefaultSaveOrUpdateEventListener.entityIsTransient(DefaultSaveOrUpdateEventListener.java:177)
	at org.hibernate.event.internal.DefaultSaveEventListener.performSaveOrUpdate(DefaultSaveEventListener.java:32)
	at org.hibernate.event.internal.DefaultSaveOrUpdateEventListener.onSaveOrUpdate(DefaultSaveOrUpdateEventListener.java:73)
	at org.hibernate.internal.SessionImpl.fireSave(SessionImpl.java:679)
	at org.hibernate.internal.SessionImpl.save(SessionImpl.java:671)
	at org.hibernate.internal.SessionImpl.save(SessionImpl.java:666)
	at com.spk.ManageEmployee.addAddress(ManageEmployee.java:32)
	at com.spk.Test.main(Test.java:10)
Hibernate: insert into employee (street_name, city_name, state_name, zipcode, first_name, last_name, salary) values (?, ?, ?, ?, ?, ?, ?)
org.hibernate.MappingException: Unknown entity: com.spk.Address
	at org.hibernate.internal.SessionFactoryImpl.getEntityPersister(SessionFactoryImpl.java:781)
	at org.hibernate.internal.SessionImpl.getEntityPersister(SessionImpl.java:1520)
	at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:100)
	at org.hibernate.event.internal.DefaultSaveOrUpdateEventListener.saveWithGeneratedOrRequestedId(DefaultSaveOrUpdateEventListener.java:192)
	at org.hibernate.event.internal.DefaultSaveEventListener.saveWithGeneratedOrRequestedId(DefaultSaveEventListener.java:38)
	at org.hibernate.event.internal.DefaultSaveOrUpdateEventListener.entityIsTransient(DefaultSaveOrUpdateEventListener.java:177)
	at org.hibernate.event.internal.DefaultSaveEventListener.performSaveOrUpdate(DefaultSaveEventListener.java:32)
	at org.hibernate.event.internal.DefaultSaveOrUpdateEventListener.onSaveOrUpdate(DefaultSaveOrUpdateEventListener.java:73)
	at org.hibernate.internal.SessionImpl.fireSave(SessionImpl.java:679)
	at org.hibernate.internal.SessionImpl.save(SessionImpl.java:671)
	at org.hibernate.internal.SessionImpl.save(SessionImpl.java:666)
	at com.spk.ManageEmployee.addAddress(ManageEmployee.java:32)
	at com.spk.Test.main(Test.java:15)
Hibernate: insert into employee (street_name, city_name, state_name, zipcode, first_name, last_name, salary) values (?, ?, ?, ?, ?, ?, ?)