import { useContext, useRef } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import { Context } from "../../context/Context";
import "./login.scss";
import { loginSuccess, loginFailure, loginStart } from "../../context/Actions";

export default function Login() {
  const userRef = useRef();
  const passwordRef = useRef();
  const { dispatch, isFetching } = useContext(Context);

  const handleSubmit = async (e) => {
    e.preventDefault();
    dispatch(loginStart());
    try {
      const res = await axios.post("/auth/login", {
        username: userRef.current.value,
        password: passwordRef.current.value,
      });

      dispatch(loginSuccess(res.data));
    } catch (err) {
      dispatch(loginFailure());
    }
  };

  return (
    <div className="login">
      <h2 className="login-title">Войти</h2>
      <form className="login-form" onSubmit={handleSubmit}>
        <label>Имя пользователя</label>
        <input
          type="text"
          className="login-input"
          placeholder="Введите имя пользователя..."
          ref={userRef}
        />
        <label>Пароль</label>
        <input
          type="password"
          className="login-input"
          placeholder="Введите пароль..."
          ref={passwordRef}
        />
        <button
          type="submit"
          className="button login-button"
          disabled={isFetching}
        >
          Войти
        </button>
      </form>
      <Link className=" button " to="/register">
        Зарегистрироваться
      </Link>
    </div>
  );
}
