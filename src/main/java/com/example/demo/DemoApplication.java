package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public DemoApplication() {
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	public boolean equals(final Object o) {
		if (o == this) return true;
		if (!(o instanceof DemoApplication)) return false;
		final DemoApplication other = (DemoApplication) o;
		if (!other.canEqual((Object) this)) return false;
		return true;
	}

	protected boolean canEqual(final Object other) {
		return other instanceof DemoApplication;
	}

	public int hashCode() {
		int result = 1;
		return result;
	}

	public String toString() {
		return "DemoApplication()";
	}

}
