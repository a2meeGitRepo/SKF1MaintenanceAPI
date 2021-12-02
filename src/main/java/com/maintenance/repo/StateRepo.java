/**
 * @Dattatray Bodhale
 */
package com.maintenance.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.maintenance.model.State;


/**
 * @author lenovo
 *
 */
public interface StateRepo extends JpaRepository<State, Integer> {

}
