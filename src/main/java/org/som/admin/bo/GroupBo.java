package org.som.admin.bo;

import java.security.InvalidKeyException;
import java.util.List;

import org.som.bean.GroupFormBean;
import org.som.bean.model.Group;
import org.som.util.EnumInterface;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;

public interface GroupBo
{
	EnumInterface blockGroup(Authentication auth, @RequestBody GroupFormBean grpFormBean);

	EnumInterface checkGroupExists(Authentication auth, @RequestBody GroupFormBean grpFormBean);

	EnumInterface deleteGroup(Authentication auth, @RequestBody GroupFormBean grpFormBean);

	Group getGroup(Group grpBean);
	
	List<Group> getGroupByCustomer(Authentication auth);

	List<Group> getGroupByIdList(Authentication auth, @RequestBody GroupFormBean grpFormBean);

	EnumInterface saveGroup(Authentication auth, @RequestBody GroupFormBean grpFormBean) throws InvalidKeyException;

	EnumInterface updateGroup(Authentication auth, @RequestBody GroupFormBean grpFormBean);

	List<Group> getGroupByNameList(Authentication auth, GroupFormBean grpFormBean);

}
