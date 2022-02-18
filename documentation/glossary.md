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
