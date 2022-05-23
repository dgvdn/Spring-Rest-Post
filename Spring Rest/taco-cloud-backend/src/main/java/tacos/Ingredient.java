package tacos;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import javax.persistence.Id;
import lombok.AccessLevel;

@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
@Data
@RequiredArgsConstructor
public class Ingredient {
	@Id
	private final String id;
	private final String name;
	@Enumerated(EnumType.STRING)
	private final Type type;

	public static enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}
}
