package hariboten;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


class GroupMember {

	private static GroupMember singleton;
	private List<GroupMemberPair> GroupUserRelation;

	private GroupMember() {
		this.GroupUserRelation = new ArrayList<GroupMemberPair>();
	}

	public static synchronized GroupMember getGroupMember() {
		if (singleton == null) {
			singleton = new GroupMember();
		}
		return singleton;
	}

	public void addRelation(Id groupId, Id memberId) {
		GroupUserRelation.add(new GroupMemberPair(groupId, memberId));
	}

	public List<Entity> getMember(Id groupId) {
		return GroupUserRelation.stream()
			.filter((relation) -> relation.groupId().equals(groupId))
			.map((relation) -> relation.memberId())
			.map((memberId) -> EntityRepository.getEntityRepository().getEntity(memberId))
			.collect(Collectors.toList());
	}

	public List<Entity> getGroup(Id memberId) {
		return GroupUserRelation.stream()
			.filter((relation) -> relation.memberId().equals(memberId))
			.map((relation) -> relation.groupId())
			.map((groupId) -> EntityRepository.getEntityRepository().getEntity(groupId))
			.collect(Collectors.toList());
	}
}
