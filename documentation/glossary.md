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



### (b) For each relationship, determine relationship maxima and minima
1. organization M(0) - manages - cause M(1)
2. volunteer M(0) - supports - cause 1(0)

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
