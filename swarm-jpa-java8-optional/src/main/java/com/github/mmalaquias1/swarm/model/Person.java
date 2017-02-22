package com.github.mmalaquias1.swarm.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	private Long id;
	@Version
	@Column
	private Integer version;
	@Column(nullable = false, length = 225)
	private String name;
	@Column
	private LocalDate birthday;
	@Column(nullable = false, length = 1)
	private String sex;
	@Column(nullable = false)
	private BigDecimal weightActual;
	@Column(nullable = false)
	private BigDecimal weightDesired;
	@OneToMany(mappedBy = "person")
	private List<WeightHistory> weightHistoryList;
	
	public Person() { }

	public Person(Long id, String name, LocalDate birthday, String sex, BigDecimal weightActual, BigDecimal weightDesired) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.sex = sex;
		this.weightActual = weightActual;
		this.weightDesired = weightDesired;
	}

	public Long getId() {
		return this.id;
	}

	public Integer getVersion() { return this.version; }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public BigDecimal getWeightActual() {
		return weightActual;
	}

	public void setWeightActual(BigDecimal weightActual) {
		this.weightActual = weightActual;
	}

	public BigDecimal getWeightDesired() {
		return weightDesired;
	}

	public void setWeightDesired(BigDecimal weightDesired) {
		this.weightDesired = weightDesired;
	}

	public Optional<List<WeightHistory>> getWeightHistoryList() {
		return Optional.ofNullable(weightHistoryList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Person{" + "id=" + id + ", version=" + version + ", name='"
				+ name + '\'' + ", birthday=" + birthday + ", sex='" + sex
				+ '\'' + ", weightActual=" + weightActual + ", weightDesired="
				+ weightDesired + '}';
	}
}
