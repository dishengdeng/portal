/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.portal.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import com.portal.web.entity.Employee;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Mike
 */
// tag::code[]
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select t from Employee t where t.firstName = :firstName")
    Employee findByEmployeename(@Param("firstName") String firstName);
    
    
    @Query("select t from Employee t where t.id = :id")
    Employee findById(@Param("id") Long id);
}
// end::code[]
