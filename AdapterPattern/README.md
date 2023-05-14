```plantuml
@startuml
top to bottom direction
skinparam linetype ortho

class ClassAdapter
class Client
class DataServiceJSON
class DataServiceXML
interface ServiceJSON << interface >>
interface ServiceXML << interface >>
class ObjectAdapter

ClassAdapter     -[#000000,plain]-^  DataServiceJSON
ClassAdapter     -[#000000,dashed]-^  ServiceJSON    
Client           -[#000000,plain]->  ServiceJSON    
Client           -[#000000,plain]->  ServiceXML     
DataServiceXML   -[#000000,dashed]-^  ServiceXML     
ObjectAdapter    -[#000000,dashed]-^  ServiceJSON
ObjectAdapter    -[#000000,plain]-> DataServiceJSON
@enduml```