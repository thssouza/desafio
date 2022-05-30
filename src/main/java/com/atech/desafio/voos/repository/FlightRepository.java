package com.atech.desafio.voos.repository;

import java.util.List;

import org.hibernate.jpa.TypedParameterValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.atech.desafio.voos.model.Flight;
import com.atech.desafio.voos.model.transfer.FlightDTO;

@Repository
public interface FlightRepository extends JpaRepository <Flight,Long> {

	@Query(value = "SELECT new com.atech.desafio.voos.model.transfer.FlightDTO (fl.id,"
			+ "                                                                 fl.plane.model,"
			+ "                                                                 fl.plane.tailCode,"
			+ "                                                                 fl.pilot.name,"
			+ "                                                                 fl.pilot.active,"
			+ "                                                                 fl.cityDepart.name,"
			+ "                                                                 fl.cityArrive.name,"
			+ "                                                                 fl.departTime,"
			+ "                                                                 fl.arriveTime,"
			+ "                                                                 fl.status.description"
			+ ") "
			+ "     FROM Flight fl "
			+ "     WHERE (UPPER(CAST(fl.pilot.name as text)) LIKE CONCAT('%', UPPER(CAST(:pilotName as text)), '%') OR CAST(:pilotName as text) IS NULL) "
			+ "       AND (CAST(fl.plane.model as text) = CAST(:planeModel as text) OR CAST(:planeModel as text) IS NULL)"
			+ "       AND (CAST(fl.plane.tailCode as text) = CAST(:planeTailCode as text) OR CAST(:planeTailCode as text) IS NULL)"
			+ "       AND (CAST(fl.cityDepart.name as text) = CAST(:cityDepart as text) OR CAST(:cityDepart as text) IS NULL)"
			+ "       AND (CAST(fl.cityArrive.name as text) = CAST(:cityArrive as text) OR CAST(:cityArrive as text) IS NULL)"
			+ "       AND (CAST(fl.departTime as date) = case when CAST(COALESCE(:departTime, NULL) as date) is null then CAST(fl.departTime as date) else CAST(COALESCE (:departTime, NULL) as date) END)"
			+ "       AND (CAST(fl.arriveTime AS date) = CAST(COALESCE(:arriveTime, NULL) AS date) OR CAST (COALESCE(:arriveTime, NULL) AS date) IS NULL)"
			+ "       AND (CAST(fl.status.description as text) = CAST(:statusDescription as text) OR CAST(:statusDescription as text) IS NULL)"
			)
	public List<FlightDTO> findByFilter (final @Param("pilotName") String pilotName,
										 final @Param("planeModel") String planeModel,
									     final @Param("planeTailCode") String planeTailCode,
									     final @Param("cityDepart") String cityDepart,
									     final @Param("cityArrive") String cityArrive,
									     final @Param("departTime") TypedParameterValue departTime,
									     final @Param("arriveTime") TypedParameterValue arriveTime,
									     final @Param("statusDescription") String statusDescription
										);
}
