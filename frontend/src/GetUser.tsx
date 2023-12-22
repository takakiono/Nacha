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
          const response = await fetch("http://0.0.0.0:8801/nacha/group/user?groupId=1", { method: "GET" });
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
        <table>
          <thead>
            <tr>
              <th>ユーザID</th>
              <th>名前</th>
            </tr>
          </thead>
          <tbody>
            {users.map(user => (
              <tr key={user.userId}>
                  <td>{user.userId}</td>
                  <td>{user.userName}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
}
  
  
  
  
  
