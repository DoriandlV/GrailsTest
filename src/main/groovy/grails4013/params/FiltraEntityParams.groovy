package grails4013.params

import grails.validation.Validateable

class FiltraEntityParams implements Validateable {

    Integer age

    static constraints = {
        age nullable: false, min: 0
    }

}
