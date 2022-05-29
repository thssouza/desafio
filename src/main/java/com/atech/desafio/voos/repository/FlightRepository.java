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
			+ "     WHERE (UPPER(fl.pilot.name) LIKE CONCAT('%', UPPER(:pilotName), '%') OR :pilotName IS NULL) "
			+ "       AND (fl.plane.model = :planeModel OR :planeModel IS NULL)"
			+ "       AND (fl.plane.tailCode = :planeTailCode OR :planeTailCode IS NULL)"
			+ "       AND (fl.cityDepart.name = :cityDepart OR :cityDepart IS NULL)"
			+ "       AND (fl.cityArrive.name = :cityArrive OR :cityArrive IS NULL)"
			+ "       AND (CAST(fl.departTime as date) = CAST(COALESCE(:departTime, NULL) as date) OR CAST (COALESCE (:departTime, NULL) as date) IS NULL)"
			+ "       AND (CAST(fl.arriveTime AS date) = CAST(COALESCE(:arriveTime, NULL) AS date) OR CAST (COALESCE(:arriveTime, NULL) AS date) IS NULL)"
			+ "       AND (fl.status.description = :statusDescription OR :statusDescription IS NULL)"
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
