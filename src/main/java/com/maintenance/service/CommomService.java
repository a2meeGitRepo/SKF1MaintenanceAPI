/**
 * Dattatray Bodhale
	06-May-2021
 */
package com.maintenance.service;

import java.util.List;
import java.util.Optional;

import com.maintenance.model.Branch;
import com.maintenance.model.City;
import com.maintenance.model.MailManager;
import com.maintenance.model.State;

/**
 * @author Dattatray Bodhale
 *
 */
public interface CommomService {

	/**
	 * @return
	 */
	List<City> getAllCity();

	/**
	 * @param stateId
	 * @return
	 */
	List<City> getCitiesByState(int stateId);

	/**
	 * @return
	 */
	List<State> getAllState();

	/**
	 * @param string
	 * @return
	 */
	Branch getBranchByName(String string);

	/**
	 * @param string
	 * @return
	 */
	City getCityByName(String string);

	/**
	 * @param mailManageId
	 * @return
	 */
	Optional<MailManager> getMailManagerById(int mailManageId);

	/**
	 * @return
	 */
	List<MailManager> getAllMailManager();

	/**
	 * @param mailManager
	 */
	void addNewMailManager(MailManager mailManager);

	/**
	 * @return
	 */
	List<MailManager> getAllMailManagerForNewService();
	List<MailManager> getAllMailManagerForNewOffer();
	List<MailManager> getAllMailManagerForInspectionReport();



}



