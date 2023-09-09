import React, { useState, useEffect } from "react";

interface User {
    userId: string;
    userName: string;
}
  
interface ApiResponse {
    users: User[];
}

export const GetUser = () =>{
    const [users, setUsers] = useState<User[]>([]);
  
    useEffect(() => {
      async function fetchData() {
        try {
          const response = await fetch("http://0.0.0.0:8801/nacha/user?groupId=1", { method: "GET" });
          const data: ApiResponse = await response.json();
          setUsers(data.users);
        } catch (error) {
          console.error('データの取得に失敗しました', error);
        }
      }
  
      fetchData();
    }, []);
  
    return (
      <div>
        <h1>User List</h1>
        <ul>
          {users.map(user => (
            <li key={user.userId}>
                {user.userId}:
                {user.userName}
            </li>
          ))}
        </ul>
      </div>
    );
}
  
  
  
  
  
