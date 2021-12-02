/**
 *  Dattatray Bodhale
 * 04-Mar-2021
 */
package com.maintenance.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.UserDetails;
import com.maintenance.model.Usermst;




/**
 * @author datta
 *
 */
public interface UserRepo extends JpaRepository<UserDetails, Integer>,UserCustomeRepo {

	

	/**
	 * @param userId
	 * @return
	 */
	@Query("from UserDetails u where u.id=?1")
	Optional<UserDetails> findAllByUserId(String userId);

	/**
	 * @param userName
	 * @return
	 */
	@Query("from Usermst u where u.username=?1")
	Usermst findByUserName(String userName);

	/**
	 * @param username
	 * @return
	 */
	@Query("from UserDetails u where u.username=?1")
	Optional<UserDetails> findUserDetialsByUserName(String username);

	/**
	 * @param contString
	 * @return
	 */
	@Query("select count(u)From UserDetails u")
	int getCountBySubString();

	/**
	 * @param contString
	 * @return
	 */
	@Query("select  MAX(u.id) From UserDetails u")
	String getMaxCodeBySubString();

	/**
	 * @return
	 */
	@Query("from UserDetails u where u.deletbit=0")
	List<UserDetails> getAllUser();

	/**
	 * @param userId
	 * @param password
	 * @return
	 */
	@Query("from Usermst u where u.username=?1 and u.password=?2")
	Usermst getUserByUserNamePassword(String userId, String password);



}
