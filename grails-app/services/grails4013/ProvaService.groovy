package grails4013

import grails.gorm.transactions.Transactional
import grails.validation.ValidationException
import grails.web.databinding.DataBinder

class ProvaService implements DataBinder {

    @Transactional
    void inizializza() {
        [
            [name: "foo", age: 42],
            [name: "bar", age: 18]
        ].each { params ->
            def entity = new EntityTest()
            bindData(entity, params)
            if(!entity.save()) throw new ValidationException("Errore creazione entity", entity.errors)
        }
    }

    List<EntityTest> listaEntity() {
        return EntityTest.list()
    }

    List<EntityTest> filtraEntity(int age) {
        return EntityTest.findAllByAgeGreaterThanEquals(age)
    }

}
