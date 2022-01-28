import { useContext, useState } from "react";
import axios from "axios";

import { Context } from "../../context/Context";
import Sidebar from "../../components/sidebar/Sidebar";
import "./settings.scss";
import img from "../../resources/user.jpg";

import {
  updateStart,
  updateSuccess,
  updateFailure,
} from "../../context/Actions";

export default function Settings() {
  const { user, dispatch } = useContext(Context);
  const [file, setFile] = useState(null);
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [success, setSuccess] = useState(false);
  const PublicFolder = "http://localhost:3000/images/";

  const handleSubmit = async (e) => {
    e.preventDefault();
    dispatch(updateStart());
    const updatedUser = {
      userId: user._id,
      username,
      email,
      password,
    };
    if (file) {
      const data = new FormData();
      const filename = Date.now() + file.name;
      data.append("name", filename);
      data.append("file", file);
      updatedUser.profilePic = filename;
      try {
        await axios.post("/upload", data);
      } catch (error) {}
    }
    try {
      const res = await axios.put("/users/" + user._id, updatedUser);
      setSuccess(true);
      dispatch(updateSuccess(res.data));
    } catch (error) {
      dispatch(updateFailure());
    }
  };

  return (
    <div className="settings">
      <div className="settings-wrapper">
        <div className="settings-title">
          <h2 className="settings-title__update">Редактировать профиль</h2>
        </div>
        <form className="settings-form" onSubmit={handleSubmit}>
          <label>Аватар</label>
          <div className="settings-profile-img">
            {user.profilePic ? (
              <img
                src={
                  file
                    ? URL.createObjectURL(file)
                    : PublicFolder + user.profilePic
                }
                alt={user.username}
              />
            ) : (
              <img src={img} alt={user.username} />
            )}

            <label htmlFor="file-input">
              <i className="settings-profile-icon  far fa-user-circle"></i>
            </label>
            <input
              type="file"
              id="file-input"
              className="settings-file"
              onChange={(e) => setFile(e.target.files[0])}
            />
          </div>
          <label>Имя пользователя</label>
          <input
            type="text"
            placeholder={user.username}
            onChange={(e) => setUsername(e.target.value)}
          />
          <label>Email</label>
          <input
            type="email"
            placeholder={user.email}
            onChange={(e) => setEmail(e.target.value)}
          />
          <label>Пароль</label>
          <input
            type="password"
            onChange={(e) => setPassword(e.target.value)}
          />
          <button className="button" type="submit">
            Обновить
          </button>
          {success && (
            <span className="success">Профиль успешно обновлен</span>
          )}
        </form>
      </div>
      <Sidebar />
    </div>
  );
}
