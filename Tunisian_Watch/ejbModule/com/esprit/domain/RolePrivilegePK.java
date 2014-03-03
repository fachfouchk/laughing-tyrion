package com.esprit.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class RolePrivilegePK implements Serializable {
	
	private int IdRolePk;
	
	private int IdPrivilegePk;
	
	

	public RolePrivilegePK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RolePrivilegePK(int idRolePk, int idPrivilegePk) {
		super();
		IdRolePk = idRolePk;
		IdPrivilegePk = idPrivilegePk;
	}

	public int getIdRolePk() {
		return IdRolePk;
	}

	public void setIdRolePk(int idRolePk) {
		IdRolePk = idRolePk;
	}

	public int getIdPrivilegePk() {
		return IdPrivilegePk;
	}

	public void setIdPrivilegePk(int idPrivilegePk) {
		IdPrivilegePk = idPrivilegePk;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IdPrivilegePk;
		result = prime * result + IdRolePk;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolePrivilegePK other = (RolePrivilegePK) obj;
		if (IdPrivilegePk != other.IdPrivilegePk)
			return false;
		if (IdRolePk != other.IdRolePk)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RolePrivilegePK [IdRolePk=" + IdRolePk + ", IdPrivilegePk="
				+ IdPrivilegePk + "]";
	}
	
	
	
	

	
}
