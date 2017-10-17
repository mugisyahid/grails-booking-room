package com.ligarisma.booking

import grails.gorm.services.Service

@Service(HostedAt)
interface HostedAtService {

    HostedAt get(Serializable id)

    List<HostedAt> list(Map args)

    Long count()

    void delete(Serializable id)

    HostedAt save(HostedAt hostedAt)

}