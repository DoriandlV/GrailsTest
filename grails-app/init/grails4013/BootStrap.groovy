package grails4013

class BootStrap {

    def provaService

    def init = { servletContext ->
        provaService.inizializza()
    }

    def destroy = {
    }

}
