package com.github.mmalaquias1.swarm.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Optional;

@Entity
public class WeightHistory implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	private Long id;
	@Version
	@Column
	private Integer version;
	@Column(nullable = false)
	private BigDecimal weight;
	@ManyToOne
	private Person person;

	public WeightHistory() {
	}

	public WeightHistory(BigDecimal weight, Person person) {
		this.weight = weight;
		this.person = person;
	}

	public Long getId() { return this.id; }

	public Integer getVersion() { return this.version; }

	public BigDecimal getWeight() { return weight; }

	public Optional<Person> getPerson() { return Optional.ofNullable(person); }

	@Override
	public String toString() {
		return "WeightHistory{" +
				"id=" + id +
				", version=" + version +
				", weight=" + weight +
				", person=" + person +
				'}';
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof WeightHistory)) {
			return false;
		}
		WeightHistory other = (WeightHistory) obj;
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
}
