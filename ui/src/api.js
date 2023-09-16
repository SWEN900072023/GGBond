// api.js
const API_BASE_URL = process.env.REACT_APP_API_BASE_URL || 'http://localhost:8080/MusicEventSystem_war_exploded';

export async function login(username, password) {
  const response = await fetch(`${API_BASE_URL}/hello-servlet`, {
    method: 'GET',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded',
    },
    body: `username=${username}&password=${password}`,
  });
  return response;
}
