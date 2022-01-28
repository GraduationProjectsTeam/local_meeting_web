import { Link } from "react-router-dom";

import noPhoto from "../../resources/no-photos.png";
import "./post.scss";

export default function Post({ post }) {
  const PublicFolder = "http://localhost:3000/images/";

  return (
    <div className="post">
      <Link to={`/post/${post._id} `}>
        {post.photo ? (
          <img
            className="post-img"
            src={PublicFolder + post.photo}
            alt={post.title}
          />
        ) : (
          <img className="post-img no-photo" src={noPhoto} alt={post.title} />
        )}
      </Link>
      <div className="post-info">
        <div className="post-categories">
          {post.categories.map((category) => (
            <span className="post-category">{category.name}</span>
          ))}
        </div>
        <Link to={`/post/${post._id} `}>
          <h5 className="post-title">{post.title}</h5>
        </Link>
        <p className="post-desc">{post.desc}</p>
        <p className="post-date">
          {new Date(post.createdAt).toDateString("ru", {
            year: "numeric",
            month: "long",
            day: "numeric",
          })}
        </p>
      </div>
    </div>
  );
}
