package hariboten;

class GroupMemberPair {
	private Id groupId;
	private Id memberId;

	public GroupMemberPair(Id groupId, Id memberId) {
		this.groupId = groupId;
		this.memberId = memberId;
	}
	public Id groupId(){
		return this.groupId;
	}
	public Id memberId(){
		return this.memberId;
	}
}
