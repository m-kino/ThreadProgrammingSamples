package bukai_20181023;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Request {

	private String name;

	@Override
	public String toString() {
		return String.format("[Request: %s]", name);
	}

}
