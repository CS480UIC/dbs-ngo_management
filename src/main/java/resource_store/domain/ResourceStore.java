package resource_store.domain;

/**
 * User object
 * 
 *
 * 
 */
public class ResourceStore {
	/*
	 * Correspond to the user table
	 */
	
	private Integer resource_id;
	private String name;
	private String type_name; 
	private Float resource_count;

	public Integer getResource_id() {
		return resource_id;
	}

	public void setResource_id(Integer resource_id) {
		this.resource_id = resource_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public Float getResource_count() {
		return resource_count;
	}

	public void setResource_count(Float resource_count) {
		this.resource_count = resource_count;
	}

	@Override
	public String toString() {
		return "ResourceStore [resource_id=" + resource_id + ", name=" + name + ", type_name=" + type_name
				+ ", resource_count=" + resource_count + "]";
	}
}
