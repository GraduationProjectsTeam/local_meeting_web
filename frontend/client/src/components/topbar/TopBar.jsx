import { useContext } from "react";
import { Link } from "react-router-dom";
import { Context } from "../../context/Context";

import "./topbar.scss";
import img from "../../resources/user.jpg";
import { ReactComponent as Logo } from "../../resources/logo.svg";
export default function TopBar() {
  const { user, dispatch } = useContext(Context);
  const PublicFolder = "http://localhost:3000/images/";
  const handleLogout = () => {
    dispatch({ type: "LOGOUT" });
  };
  return (
    <div className="top">
      <Link to="/" className="top-left">
        <Logo className="logo" />
        <span>Информационный портал</span>
      </Link>

      <div className="top-right">
      <Link to='/write' className='button'>Добавить мероприятие</Link>
        {user ? (
          <>
            <Link to="/settings">
              <img
                className="top-img"
                src={user.profilePic ? PublicFolder + user.profilePic : img}
                alt=""
              />
            </Link>
            <div className="top-list__item" onClick={handleLogout}>
              {user && "Выйти"}
            </div>
          </>
        ) : (
          <ul className="top-list">
            <li className="top-list__item">
              <Link to="/login">Войти </Link>
            </li>
            <li className="top-list__item">
              <Link to="/register">Регистрация</Link>
            </li>
          </ul>
        )}
      </div>
    </div>
  );
}
