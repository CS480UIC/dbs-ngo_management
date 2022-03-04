### (a) For each entity, document name, synonyms, and description
#### 1.  **Entity Name**: cause

**Synonyms**: charity, objective, focus area

**Description**: 
>A cause or focus area is a disability or social problem to which a particular organization provides support. This entity consists of any issue for which there exists an organization or there is a plan to support the cause in the future.

#### 2.  **Entity Name**: organization

**Synonyms**: institution, group, establishment

**Description**:
>An organization or institution is an establishment by the NGO that focuses on a specific subset of causes and provides support for people suffering from those causes by allocating resources and funds for the people.

#### 3.  **Entity Name**: volunteer

**Synonym**: participant

**Description**: 
>A volunteer is a person who is not directly affiliated or employed by the NGO but offers services upon free will. A volunteer does not include a donor as a volunteer does not make material donations but offers up time to help at an institution, setup fundraiser events for a cause or other campaigns related to a cause.

#### 4.  **Entity Name**: donation

**Synonym**: contribution, benefaction

**Description**:
>This entity keeps track of specific donations made by a donor and the resources donated and type of donation made.

#### 5.  **Entity Name**: resource_store

**Synonym**: funds, supplies, materials

**Description**:
>This entity consists of the resources donated by donors through a donation. This is a central storage which later provides resources to a specific organization whenever needed.

#### 6.  **Entity Name**: resource_usage

**Synonym**: fund_usage, supply_ussage

**Description**:
>resource_usage is an entity that keeps track of usage of resources made by each organization that have taken the resources from the resource_store. This table lets donors see how the donations are being utilized by various organizations.

#### 7.  **Entity Name**: employee

**Synonym**: worker, staff member

**Description**:
>An employee is a person working in an organization to take care of people residing in an institution. This entity consists of all people employed by the NGO full time and does not include part-time workers or volunteers.

#### 8.  **Entity Name**: donor
  
**Synonym**: benefactor, contributor, sponsor

**Description**:
>A donor is an external entity to the NGO who provides financial support to the NGO or a particular organization that belongs to the NGO. The donor could donate money or provide any other material resources that could help benefit the people in an NGO organization.



### (b) For each relationship, determine relationship maxima and minima
1. organization M(0) - manages - cause M(1)
2. volunteer M(0) - supports - cause 1(0)
3. donation 1(0) - stores in - resource_store 1(1)
4. resource_usage M(0) - takes from - resource_store M(1)
5. employee M(0) - works in - organization 1(1)
6. donor 1(0) - makes - donation M(0)
7. organization M(0) - uses - resource_usage M(0)

### (c) For each attribute, determine attribute maxima and minima
#### 1.  **cause Attributes**:
>cause_id: 1-1(1)  
>cause_name: 1-1(1)

#### 2.  **organization Attributes**:
>organization_id: 1-1(1)  
>organization_name: M-1(1)  
>support_cause_id: M-M(1)  
>address: 1-1(1)  
>email: 1-M(1)  
>phone: 1-M(1)  

#### 3.  **volunteer Attributes**:
>volunteer_id: 1-1(1)  
>first_name: M-1(1)  
>last_name: M-1(1)  
>birth_date: M-1(1)  
>address: 1-1(1)  
>email: 1-M(0)  
>phone: 1-M(1)  
>support_cause_id: M-M(0)  

#### 4.  **donation Attributes**:
>transaction_id: 1-1(1)  
>donor_id: M-1(0)  
>resource_id: 1-1(1)  
>time: M-1(1)  
>donation_type: M-M(1)  
>amount: M-1(0)  

#### 5.  **resource_store Attributes**:
>resource_id: 1-1(1)  
>name: M-1(1)  
>type_name: M-1(1)  
>resource_count: M-1(1)  

#### 6.  **resource_usage Attributes**:
>resource_id: M-M(1)  
>organization_id: M-M(1)  
>usage_count: M-M(1)  

#### 7.  **employee Attributes**:
>employee_id: 1-1(1)   
>first_name: M-1(1)   
>last_name: M-1(1)   
>ssn: 1-1(1)   
>organization_id: M-1(1)   
>birth_date: M-1(1)   
>address: 1-1(1)  
>email: 1-M(0)  
>phone: 1-M(1)   

 

#### 8.  **donor Attributes**:
>donor_id: 1-1(1)  
>first_name: M-1(1)  
>last_name: M-1(1)  
>birth_date: M-1(1)  
>address: 1-1(1)  
>email: 1-1(0)   
>phone: 1-1(1)   
>num_of_donations: M-1(0)   
>last_donation: M-1(0)   


### Document dependent entities and dependency relationships:
>Dependent entities are cause_organization, volunteer_support_cause, employee, donation, resource_usage, donation_donation_type, resource_store, volunteer, donor   

### Dependency relationships:
>1) cause_organization depends on cause and organization   
>2) volunteer_support_cause is supported by volunteer   
>3) employee belongs to an organization   
>4) resource_store used by organization   
>5) volunteer works in organization   
>6) donor contributes in organization   
>7) donation made by donor   
>8) resource_usage made from resource_store   
>9) resource_usage done by an organization   
>10) donation_donation_type made type of donation   

### Document supertypes, subtypes and partitions:
>volunteer is a super type entity of donor entity   
>volunteer is a super type entity of employee entity   

### Partitions:
>There are no partitions   

### Implementing attributes:
>1) Entity: cause   
Attribute Name: cause_id Type: INTEGER Description: The cause_id specifies the unique id of a cause supported by the NGO.   
Attribute Name: cause_name Type: varchar(30) Description: This is the name of the cause supported by an organization.   

>2) Entity: organization   
Attribute Name: organization_id Type: INTEGER Description: each and every organization will be having different and unique id.    
Attribute Name: organization_name Type: VARCHAR(50) Description: name specifies the string for the organization.    
Attribute Name: Address Type: VARCHAR(75) Description: specifies the address for the organization.   
Attribute Name: email Type: VARCHAR(25) Description: Stores the email-id of the organization.   
Attribute Name: phone Type: CHAR(10) Description:Stores the mobile number of the organization.   

>3) Entity: volunteer   
Attribute Name: volunteer_id Type: INTEGER Description: Uniquely stores the volunteer records in a table.   
Attribute Name: First_name Type: VARCHAR(20) Description: First name specifies the string for the first name of the volunteer.   
Attribute Name: last_name Type: VARCHAR(20) Description: The last name specifies the string for the first name of the volunteer.   
Attribute Name: birth_date Type: DATE Description: Specifies the date of birth of the volunteer.   
Attribute Name: Address Type: VARCHAR(75) Description: specifies the address for the volunteer.   
Attribute Name: email Type: VARCHAR(20) Description: Stores the email-id of the volunteer.   
Attribute Name: phone Type: CHAR(10) Description:Stores the mobile number of the volunteer.   

>4) Entity: cause_organization   
Attribute Name: cause_id Type: INTEGER Description: It specifies the id of a cause being supported by an organization.   
Attribute Name: organization_id Type: INTEGER Description: It specifies the id of an organization that supports a cause.   

>5) Entity: donation   
Attribute Name: transaction_id Type: INTEGER Description: specifies the id of the transaction made for donation.   
Attribute Name: donor_id Type: INTEGER Description: The donor_id specifies the unique id stored for the donor.   
Attribute Name: resource_id Type: INTEGER Description: The resource_id specifies the resource_id which is donated.   
Attribute Name: Time Type:DATETIME: Stores the time at which the donation was made.  
Attribute Name: amount Type: DECIMAL(10, 2) Description: stores the amount donated by donor.   

>6) Entity: resource_store   
Attribute Name: resource_id Type: INTEGER Description: The resource_id specifies the unique id of the donation stored in the inventory.   
Attribute Name: name Type: VARCHAR(30) Description: The resource name specifies the name of the items donated.   
Attribute Name: type_name Type:varchar(20)  Description: This describes the type of the resource stored in the inventory.   
Attribute Name: resource_count Type:DECIMAL(10, 2) Description: This describes the amount of resource available in the inventory.   


>7) Entity: resource_usage   
Attribute Name: usage_id Type: INTEGER Description: This specifies the unique usage id made by an organization.   
Attribute Name: resource_id Type: INTEGER Description: This specifies the resource id that was used by an organization.    
Attribute Name: organization_id Type: INTEGER Description: This describes the organization id that made usage of a particular resource.   
Attribute Name: usage_count Type: INTEGER Description: This describes the amount of resource used by an organization.   


