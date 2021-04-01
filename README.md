# API for the tutti.ch site
Simple API of Item of tutti.ch

## Version: 1.0.0

**Contact information:**  
mohamed.boutaleb@student.supsi.ch  

**License:** [Apache 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

### /items/all

#### GET
##### Summary

get all items

##### Description

Get all the available items in the site

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | Returns all the items in json array |
| 400 | bad input parameter |

### /items/

#### POST
##### Summary

adds an item on tutti.ch

##### Description

Adds an item to the system

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | Returns the item created |
| 400 | invalid input, object invalid |

### /items/{id}

#### GET
##### Summary

get a specific existing item

##### Description

Get the item from the system if exists

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path | Item ID | Yes | long |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | Returns the item if exists |
| 404 | Item with that Id do not exists |

#### DELETE
##### Summary

deletes an item on tutti.ch

##### Description

Deletes an existing item on the system

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path |  | Yes | integer |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | item deleted |
| 404 | item id not found |

#### PUT
##### Summary

updates/creates an item on tutti.ch

##### Description

Updates/creates an item to the system

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path |  | Yes | integer |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | item updated |
| 201 | item created |
| 400 | invalid input, object invalid |

#### PATCH
##### Summary

updates an item that already exists on tutti.ch

##### Description

Updates a existing item to the system

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path | Item to add to the site | Yes | object |

##### Responses

| Code | Description |
| ---- | ----------- |
| 400 | invalid input, object invalid |
| 404 | item id, not found |

### Models

#### IncompleteInventoryItem

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| author | string | _Example:_ `"Thomas Anderson"` | Yes |

#### InventoryItem

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| author | string | _Example:_ `"Richard Gere"` | Yes |
| title | string | _Example:_ `"Iphone 11 256 4 month warrancy"` | Yes |
| description | string | _Example:_ `"I sell a new iphone 11 with 256 gb of ssd with warrancy"` | Yes |
