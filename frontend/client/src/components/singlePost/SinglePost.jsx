import { Link, useLocation } from "react-router-dom";
import { useEffect, useState } from "react";
import axios from "axios";
import { Context } from "../../context/Context";
import { useContext } from "react";
import "./singlePost.scss";

export default function SinglePost() {
  const location = useLocation();
  const path = location.pathname.split("/")[2];
  const [post, setPost] = useState({});
  const PublicFolder = "http://localhost:3000/images/";
  const { user } = useContext(Context);
  const [title, setTitle] = useState("");
  const [desc, setDesc] = useState("");
  const [updateMode, setUpdateMode] = useState(false);

  useEffect(() => {
    const getPost = async () => {
      const response = await axios.get("/posts/" + path);
      setPost(response.data);
      setTitle(response.data.title);
      setDesc(response.data.desc);
    };
    getPost();
  }, [path]);

  const handleUpdate = async () => {
    try {
      await axios.put(`/posts/${post._id}`, {
        username: user.username,
        title,
        desc,
      });
      // window.location.reload();
      setUpdateMode(false);
    } catch (error) {}
  };

  const handleDelete = async () => {
    try {
      await axios.delete(`/posts/${post._id}`, {
        data: { username: user.username },
      });
      window.location.replace("/");
    } catch (error) {}
  };

  return (
    <div className="single-post">
      <div className="single-post__wrapper">
        {post.photo && (
          <img
            className="single-post__img"
            src={PublicFolder + post.photo}
            alt={title}
          />
        )}
        {updateMode ? (
          <input
            type="text"
            value={title}
            className="single-post__title-input"
            autoFocus
            onChange={(e) => setTitle(e.target.value)}
          />
        ) : (
          <h1 className="single-post__title">
            {title}
            {post.username === user?.username && (
              <div className="single-post__edit">
                <i
                  className="single-post__icon fas fa-edit"
                  onClick={() => setUpdateMode(true)}
                ></i>
                <i
                  className="single-post__icon far fa-trash-alt"
                  onClick={handleDelete}
                ></i>
              </div>
            )}
          </h1>
        )}
        <div className="single-post__info">
          <span className="single-post__author">
            Author:&nbsp; 
            <Link to={`/?user=${post.username}`}>
              <b>{post.username}</b>
            </Link>
          </span>
          <span className="single-post__date">
            {new Date(post.createdAt).toDateString()}
          </span>
        </div>
        {updateMode ? (
          <textarea
            className="single-post__desc-input"
            value={desc}
            onChange={(e) => setDesc(e.target.value)}
          />
        ) : (
          <p className="single-post__desc">{desc}</p>
        )}
        {updateMode && (
          <button className="button" onClick={handleUpdate}>
            Update
          </button>
        )}
      </div>
    </div>
  );
}
