import { useState } from "react";
import axios from "axios";
import { Context } from "../../context/Context";
import { useContext } from "react";

import "./write.scss";
import img from "../../resources/logo.jpg";

export default function Write() {
  const [title, setTitle] = useState("");
  const [desc, setDesc] = useState("");
  const [file, setFile] = useState(null);
  const { user } = useContext(Context);

  const handleSubmit = async (e) => {
    e.preventDefault();
    const newPost = {
      username: user.username,
      title,
      desc,
    };
    if (file) {
      const data = new FormData();
      const filename = Date.now() + file.name;
      data.append("name", filename);
      data.append("file", file);
      newPost.photo = filename;
      try {
        await axios.post("/upload", data);
      } catch (error) {}
    }
    try {
      const res = await axios.post("/posts", newPost);
      window.location.replace("/post/" + res.data._id);
    } catch (error) {}
  };

  return (
    <div className="write">
      {file && (
        <img className="write-img" src={URL.createObjectURL(file)} alt="" />
      )}

      <form className="write-form" onSubmit={handleSubmit}>
        <label htmlFor="fileInput" className="write-file">
          <i className="write-icon fas fa-plus"></i>
          <span className="write-file-desc">
            {file ? "Изменить изображение" : "Добавить изображение"}
          </span>
        </label>
        <input
          type="file"
          id="fileInput"
          className="write-input write-file-input"
          onChange={(e) => setFile(e.target.files[0])}
        />
        <input
          type="text"
          placeholder="Название мероприятия"
          className="write-input"
          autoFocus={true}
          onChange={(e) => setTitle(e.target.value)}
          required
        />

        <textarea
          placeholder="Описание"
          type="text"
          className="write-input write-text"
          onChange={(e) => setDesc(e.target.value)}
          required
        ></textarea>

        <button className="button" type="submit">
          Опубликовать
        </button>
      </form>
    </div>
  );
}
