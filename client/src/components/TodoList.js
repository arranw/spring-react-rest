import React, {useEffect, useState} from 'react';
import styled from "styled-components";
import axios from "axios";

const TodoListDiv = styled.div`
    width: 50%;
    margin: auto;
`;

const TodoListItem = styled.div`
    background-color: #fff;
    margin-bottom: 1rem;
    border-radius: 5px;
    padding: 0.75rem;
`;

const TodoTitle = styled.h4`
    margin: 0;
    float: left;
`;

function TodoList(props) {
    const [todos, setTodos] = useState([]);

    useEffect(() => {
        async function fetch() {
            const res = await axios.get("/todo");
            setTodos(res.data);
        }

        fetch();
    }, []);


    return (
        <TodoListDiv>
            {todos.map(todo => (
                <TodoListItem>
                    <TodoTitle>
                        {todo.id}
                    </TodoTitle>
                    {todo.title}
                </TodoListItem>
            ))}
        </TodoListDiv>
    );
}

export default TodoList;