package in.Question2;

import java.util.Arrays;
import java.util.Objects;

public class MinMaxObj {
	int min;
	int max;

	public void setMin(int min) {
		this.min = min;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public MinMaxObj FindMinMax(int[] arr) {
		MinMaxObj store = new MinMaxObj();
		Arrays.sort(arr);
		store.setMin(arr[0]);
		store.setMax(arr[arr.length - 1]);
		return store;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MinMaxObj other = (MinMaxObj) obj;
		return max == other.max && min == other.min;
	}

	@Override
	public int hashCode() {
		return Objects.hash(max, min);
	}

	

}
