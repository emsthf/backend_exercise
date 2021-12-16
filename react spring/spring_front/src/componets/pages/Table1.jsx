import axios from 'axios';
import React, { useState, useEffect } from 'react';
import styles from './Table1.module.css';

function Table1() {
    const [studentList, setStudentList] = useState([]);

    const handleGetAll = () => {
        axios.get('http://localhost:8080/student/getAll')
        .then(function (response) {
            // 성공 핸들링
            console.log(response);
            setStudentList(response.data);
        })
        .catch(function (error) {
            // 에러 핸들링
            console.log(error);
        })
        .then(function () {
            // 항상 실행되는 영역
        });
    }

    return (
        <div className={styles.tableform}>
            <h1 className={styles.tt}>Student Table</h1>

            <button onClick={handleGetAll}>getAll</button>

            <table className="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">address</th>
                        <th scope="col">name</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        studentList.map(item => (
                            <tr key={item.id}>
                                <th scope="row">{item.id}</th>
                                <td>{item.name}</td>
                                <td>{item.address}</td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>
    );
}

export default Table1;