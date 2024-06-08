package app.book.management.data.model

data class Blogs(
    val id: Int,
    val date: String,
    val date_gmt: String,
    val guid: Guid,
    val modified: String,
    val modified_gmt: String,
    val slug: String,
    val status: String,
    val type: String,
    val link: String,
    val title: Title,
    val content: Content,
    val excerpt: Excerpt,
    val author: Int,
    val featured_media: Int,
    val comment_status: String,
    val ping_status: String,
    val sticky: Boolean,
    val template: String,
    val format: String,
    val meta: Meta,
    val categories: List<Int>,
    val tags: List<Int>,
    val jetpack_publicize_connections: List<Any>,
    val aioseo_notices: List<Any>,
    val class_list: List<String>,
    val jetpack_featured_media_url: String,
    val jetpack_likes_enabled: Boolean,
    val jetpack_sharing_enabled: Boolean,
    val jetpack_shortlink: String,
    val jetpack_related_posts: List<Any>,
    val _links: Links
)

data class Guid(
    val rendered: String
)

data class Title(
    val rendered: String
)

data class Content(
    val rendered: String,
    val protected: Boolean
)

data class Excerpt(
    val rendered: String,
    val protected: Boolean
)

data class Meta(
    val jetpack_post_was_ever_published: Boolean,
    val _jetpack_newsletter_access: String,
    val _jetpack_dont_email_post_to_subs: Boolean,
    val _jetpack_newsletter_tier_id: Int,
    val _jetpack_memberships_contains_paywalled_content: Boolean,
    val _jetpack_memberships_contains_paid_content: Boolean,
    val footnotes: String,
    val jetpack_publicize_message: String,
    val jetpack_publicize_feature_enabled: Boolean,
    val jetpack_social_post_already_shared: Boolean,
    val jetpack_social_options: JetpackSocialOptions
)

data class JetpackSocialOptions(
    val image_generator_settings: ImageGeneratorSettings
)

data class ImageGeneratorSettings(
    val template: String,
    val enabled: Boolean
)

data class Links(
    val self: List<Self>,
    val collection: List<Collection>,
    val about: List<About>,
    val author: List<Author>,
    val replies: List<Replies>,
    val version_history: List<VersionHistory>,
    val predecessor_version: List<PredecessorVersion>,
    val wp_featuredmedia: List<WpFeaturedmedia>,
    val wp_attachment: List<WpAttachment>,
    val wp_term: List<WpTerm>,
    val curies: List<Cury>
)

data class Self(
    val href: String
)

data class Collection(
    val href: String
)

data class About(
    val href: String
)

data class Author(
    val embeddable: Boolean,
    val href: String
)

data class Replies(
    val embeddable: Boolean,
    val href: String
)

data class VersionHistory(
    val count: Int,
    val href: String
)

data class PredecessorVersion(
    val id: Int,
    val href: String
)

data class WpFeaturedmedia(
    val embeddable: Boolean,
    val href: String
)

data class WpAttachment(
    val href: String
)

data class WpTerm(
    val taxonomy: String,
    val embeddable: Boolean,
    val href: String
)

data class Cury(
    val name: String,
    val href: String,
    val templated: Boolean
)

