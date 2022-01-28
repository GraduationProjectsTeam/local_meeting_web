import Post from "../post/Post";
import "./posts.scss";

export default function Posts({ posts }) {
  return (
    <div className="posts">
      {posts.map((post,idx) => (
        <Post key={idx} post={post} />
      ))}
    </div>
  );
}
