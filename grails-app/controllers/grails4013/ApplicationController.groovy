package grails4013

import grails.core.GrailsApplication
import grails.plugins.*
import grails4013.params.FiltraEntityParams
import org.springframework.http.HttpStatus

class ApplicationController implements PluginManagerAware {

    GrailsApplication grailsApplication
    GrailsPluginManager pluginManager
    def provaService

    def index() {
        [grailsApplication: grailsApplication, pluginManager: pluginManager]
    }

    /**
     * Da chiamare con GET /prova
     * Restituirà un elenco di entity in json
     */
    def lista() {
        def elenco = provaService.listaEntity()
        respond elenco
    }

    /**
     * Da chiamare con POST /prova passando come body un json fatto così:
     * {
     *     "age": 42
     * }
     * Restituirà un elenco di entity filtrate in json
     */
    def filtra(FiltraEntityParams params) {
        if(params.hasErrors()) {
            respond params.errors, status: HttpStatus.UNPROCESSABLE_ENTITY.value()
            return
        }
        def filtrate = provaService.filtraEntity(params.age)
        respond filtrate
    }

}
