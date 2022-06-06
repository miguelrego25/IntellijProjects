package Ex4;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FBFeed {
    private List<FBPost> posts;

    // CONSTRUTORES //

    public FBFeed(){
        this.posts = new ArrayList<>();
    }

    public FBFeed(List<FBPost> posts) {
        setPosts(posts);
    }

    public FBFeed(FBFeed feed) {
        setPosts(feed.getPosts());
    }

    // GETTER'S & SETTER'S //

    public List<FBPost> getPosts() {
        return this.posts.stream().map(FBPost::clone).collect(Collectors.toList());
    }

    public void setPosts(List<FBPost> posts) {
        this.posts = posts.stream().map(FBPost::clone).collect(Collectors.toList());
    }

    public FBFeed clone() {
        return new FBFeed(this);
    }
    //METODOS

    //i. Determinar o número de posts de um user public int
    //nrPosts(String user)

    public int nrPosts(String user){
        return (int) this.posts.stream().filter(le -> le.getUserName().equals(user)).count();
    }

    //ii. Determinar a lista de posts de um user public List<FBPost>
    //postsOf(String user)

    public List<FBPost> postsOf(String user){
        return this.posts.stream().filter(post -> post.getUserName().equals(user)).collect(Collectors.toList());
    }

    //iii. Determinar a lista de posts de um user num determinado intervalo de tempo public List<FBPost> postsOf(String
    //user, LocalDateTime inicio, LocalDateTime fim)

    public List<FBPost> postsOf(String user, LocalDateTime inicio, LocalDateTime fim) {
        return this.posts.stream().filter(post -> post.getUserName().equals(user)).filter(post->post.getInstantCreated().isAfter(inicio))
                .filter(post->post.getInstantCreated().isBefore(fim)).collect(Collectors.toList());
    }

    //iv. Obter um post dado o seu identificador public FBPost
    //getPost(int id)

    public FBPost getPost(int id){
        for(FBPost post : this.posts)
            if(post.getID() == id)
                return post;
        return null;
    }

    //v. Inserir um comentário num post,

    public void comment(FBPost post, String comentario){
        post.getComments().add(comentario);
    }

    //vi. Inserir um comentário num post,

    public void comment(int postid, String comentario){
        for(FBPost post : posts){
            if (post.getID()==(postid)){
                post.getComments().add(comentario);
            }
        }
    }

    //vii. Adicionar um like a um post,
    public void like(FBPost post){
        int number = post.getLikes();
        post.setLikes(number+1);
    }

    //viii. Adicionar um like a um post,

    void like(int postid){
        FBPost post = getPost(postid);
        like(post);

        //like(getPost(postid));
    }
    //ix. Determinar a lista dos 5 posts (identificador) com mais comentários public List<Integer> top5Comments(). Desenvolva
    //uma versão com iteradores externos e outra com iteradores internos.

    //externo
    public List<Integer> top5Comments(){
        List<Integer> top5 = new ArrayList<>();
        ArrayList<FBPost> copy = new ArrayList<>(posts);
        for(int i = 0; i < 5; i++) {
            FBPost mostCommented = null;
            for(FBPost post : copy)
                if(mostCommented == null || mostCommented.getComments().size() < post.getComments().size())
                    mostCommented = post;
            top5.add(mostCommented.getID());
            copy.remove(mostCommented);
        }
        return top5;
    }

    //interno
    public List<Integer> top5comments1(){
        return this.posts.stream().sorted((p1,p2) ->p2.getComments().size() - p1.getComments().size()).limit(5)
                .map(FBPost::getID).collect(Collectors.toList());
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FBFeed)) return false;
        FBFeed fbFeed = (FBFeed) o;
        return Objects.equals(getPosts(), fbFeed.getPosts());
    }
}
