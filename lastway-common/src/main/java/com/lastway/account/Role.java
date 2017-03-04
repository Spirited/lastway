package com.lastway.account;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	private String create;
	private String read;
	private String update;
	private String delete;
	private String view;
	
	@OneToMany
	@JoinTable(name = "group_permision",
			joinColumns = @JoinColumn(name = "role_id"),
			inverseJoinColumns = @JoinColumn(name = "group_id"))
	Set<Group> group = new HashSet<>();
	
	public String getCreate() {
		return create;
	}
	public void setCreate(String create) {
		this.create = create;
	}
	public String getRead() {
		return read;
	}
	public void setRead(String read) {
		this.read = read;
	}
	public String getUpdate() {
		return update;
	}
	public void setUpdate(String update) {
		this.update = update;
	}
	public String getDelete() {
		return delete;
	}
	public void setDelete(String delete) {
		this.delete = delete;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Role [id=");
		builder.append(id);
		builder.append(", create=");
		builder.append(create);
		builder.append(", read=");
		builder.append(read);
		builder.append(", update=");
		builder.append(update);
		builder.append(", delete=");
		builder.append(delete);
		builder.append(", view=");
		builder.append(view);
		builder.append(", group=");
		builder.append(group);
		builder.append("]");
		return builder.toString();
	}
	
	
}
