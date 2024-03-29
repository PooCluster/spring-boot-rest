package com.poocluster.springboot;

import org.springframework.data.jpa.repository.JpaRepository;

interface HelloWorldRepository extends JpaRepository<HelloWorld, Long> {
    /*
     * interface declaration allows for the following relational functionality:
     * - creating new HelloWorlds
     * - updating existing HelloWorlds
     * - delete HelloWorlds
     * - finding HelloWorlds
     *
     * CRUD: create, read, upload, delete
     */
}