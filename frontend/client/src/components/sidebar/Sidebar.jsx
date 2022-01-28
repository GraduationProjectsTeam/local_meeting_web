import { useState, useEffect } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import "./sidebar.scss";
import logo from "../../resources/logo.jpg";

export default function Sidebar() {
  const [cats, setCats] = useState([]);
  useEffect(() => {
    const getCats = async () => {
      const response = await axios.get("/categories");
      setCats(response.data);
    };
    getCats();
  }, []);

  return (
    <div className="sidebar">
      <div className="sidebar-item">
        <span className="sidebar-title">О портале</span>
        <p>
          Чтобы посмотреть подробнее о мероприятии, просто нажмите на него. Вы
          также можете добавить мероприятие самостоятельно, для этого достаточно
          пройти короткую регистрацию
        </p>
      </div>
      <div className="sidebar-item">
        <span className="sidebar-title">Категории</span>
        <ul className="sidebar-list">
          {cats.map((cat) => (
            <li key={cat._id} className="sidebar-list__item">
              <Link to={`/?cat=${cat.name}`}>{cat.name}</Link>
            </li>
          ))}
          <li className="sidebar-list__item">
            <Link key={"all"} to="/">
              Все
            </Link>
          </li>
        </ul>
      </div>
    </div>
  );
}
