import { useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";

import "./register.scss";

export default function Register() {
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError(false);
    try {
      const response = await axios.post("/auth/register", {
        username,
        email,
        password,
      });
      response.data && window.location.replace("/login");
    } catch (error) {
      setError(true);
    }
  };

  return (
    <div className="register">
      <h2 className="register-title">Регистрация</h2>
      <form className="register-form" onSubmit={handleSubmit}>
        <label>Имя пользователя</label>
        <input
          type="text"
          className="register-input"
          placeholder="Введите имя пользователя..."
          onChange={(e) => setUsername(e.target.value)}
        />
        <label>Email</label>
        <input
          type="text"
          className="register-input"
          placeholder="Введите ваш email..."
          onChange={(e) => setEmail(e.target.value)}
        />
        <label>Пароль</label>
        <input
          type="password"
          className="register-input"
          placeholder="Введите пароль..."
          onChange={(e) => setPassword(e.target.value)}
        />
        <button className="button" type="submit">
          Зарегистрироваться
        </button>
      </form>
       
        <Link className="login-button button" to="/login">Войти</Link>
       
      {error && <span className="error"> Что-то пошло не так...</span>}
    </div>
  );
}
