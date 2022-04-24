package resource_usage.domain;

/**
 * User object
 * 
 *
 * 
 */
public class ResourceUsage {
	/*
	 * Correspond to the user table
	 */
	
	private Integer usage_id;
	private Integer resource_id;
	private Integer organization_id;
	private Float usage_count;

	public Integer getUsage_id() {
		return usage_id;
	}

	public void setUsage_id(Integer usage_id) {
		this.usage_id = usage_id;
	}

	public Integer getResource_id() {
		return resource_id;
	}

	public void setResource_id(Integer resource_id) {
		this.resource_id = resource_id;
	}

	public Integer getOrganization_id() {
		return organization_id;
	}

	public void setOrganization_id(Integer organization_id) {
		this.organization_id = organization_id;
	}

	public Float getUsage_count() {
		return usage_count;
	}

	public void setUsage_count(Float usage_count) {
		this.usage_count = usage_count;
	}

	@Override
	public String toString() {
		return "ResourceUsage [usage_id=" + usage_id + ", resource_id=" + resource_id + ", organization_id="
				+ organization_id + ", usage_count=" + usage_count + "]";
	}
}
