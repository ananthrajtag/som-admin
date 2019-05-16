package org.som.admin.bo;

import java.security.InvalidKeyException;
import java.util.List;

import org.som.bean.GroupMemberFormBean;
import org.som.bean.model.GroupMember;
import org.som.util.EnumInterface;
import org.springframework.security.core.Authentication;

public interface GroupMemberBo
{
	EnumInterface deleteGroupMembersByGroupId(Authentication auth, GroupMemberFormBean gmfBean);

	List<GroupMember> getGroupMembersByGroupId(Authentication auth, GroupMemberFormBean gmfBean);

	GroupMember getGroupMemberById(Authentication auth, GroupMemberFormBean gmfBean);

	List<GroupMember> getGroupMemberList(Authentication auth);

	EnumInterface saveGroupMembers(Authentication auth, GroupMemberFormBean gmfBean) throws InvalidKeyException;

	EnumInterface updateGroupMember(Authentication auth, GroupMemberFormBean gmfBean) throws InvalidKeyException;

}
