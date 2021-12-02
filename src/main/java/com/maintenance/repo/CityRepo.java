/**
 * @Dattatray Bodhale
 */
package com.maintenance.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.City;


/**
 * @author lenovo
 *
 */
public interface CityRepo extends JpaRepository<City, Integer> {
	@Query("from City c where c.state.stateId=?1")
	List<City> getCitiesByState(int stateId);
	@Query("from City c where c.cityName=?1")
	Optional<City> getCityByName(String billingCityName);

}
