package grails4013

class EntityTest {

    String name
    Integer age

    static constraints = {
        name size: 1..100
        age nullable: false, min: 0
    }

    static mapping = {
        table "prova_tabella"
    }

}
